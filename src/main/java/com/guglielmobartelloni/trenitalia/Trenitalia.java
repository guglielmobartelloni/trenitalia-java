package com.guglielmobartelloni.trenitalia;

import com.guglielmobartelloni.trenitalia.exceptions.TrenitaliaEmptyArgumentException;
import com.guglielmobartelloni.trenitalia.exceptions.TrenitaliaResponseException;
import com.guglielmobartelloni.trenitalia.response.objects.autocomplete.AutocompletedStation;
import com.guglielmobartelloni.trenitalia.response.objects.travel.solution.TravelSolution;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is the main class of the library, it contains the methods to comunicate with Trenitalia's apis
 */
public class Trenitalia {

    /**
     * This method let's you autocomplete stations based on the city passed as a parameter. It returns an empty list if a match is not found
     *
     * @param city The city of the stations to autocomplete
     * @return A list of autocompleted stations
     */
    public List<String> autocompleteStations(String city) {
        if (city == null || city.isEmpty()) {
            throw new TrenitaliaEmptyArgumentException();
        }
        String apiEndpoint = String.format("https://www.lefrecce.it/msite/api/geolocations/locations?name=%s", city);

        final List<String> stationsList = Arrays.stream(Unirest.get(apiEndpoint)
                        .asObject(AutocompletedStation[].class).getBody())
                .map(AutocompletedStation::getName)
                .collect(Collectors.toList());

        return stationsList;
    }

    /**
     * This method is to get one way travel solutions from a specific date-time, the number of adults, the number of childrens and of course the origin and destination stations.
     * If somenthing goes wrong in the request, this method throws TrenitaliaResponseException
     *
     * @param autoCompletedOriginStation      Name of the origin station in the format of the autocompletion
     * @param autocompletedDestinationStation Name of the destination station in the format of the autocompletion
     * @param travelSolutionsDateTime         The date and time of the solution to search
     * @param nAdults                         Number of adults
     * @param nChildren                       Number of children
     * @param frecceSolutions                 If only Freccie solutions has to be returned
     * @param regionalOnly                    If only regional solutions has to be returned
     * @return A list of solutions
     */
    public List<TravelSolution> oneWaySolutions(String autoCompletedOriginStation, String autocompletedDestinationStation, LocalDateTime travelSolutionsDateTime, int nAdults, int nChildren, boolean frecceSolutions, boolean regionalOnly) {
        if (Stream.of(autocompletedDestinationStation, autoCompletedOriginStation, travelSolutionsDateTime).anyMatch(Objects::isNull) || autoCompletedOriginStation.isEmpty() || autocompletedDestinationStation.isEmpty()) {
            throw new TrenitaliaEmptyArgumentException();
        }

        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final String date = dateFormatter.format(travelSolutionsDateTime);
        final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH");
        final String time = timeFormatter.format(travelSolutionsDateTime);

        String apiEndpoint = String.format("https://www.lefrecce.it/msite/api/solutions?origin=%s&destination=%s&arflag=A&adate=%s&atime=%s&adultno=%s&childno=%s&direction=A&frecce=%s&onlyRegional=%s",
                autoCompletedOriginStation,
                autocompletedDestinationStation,
                date,
                time,
                nAdults,
                nChildren,
                frecceSolutions,
                regionalOnly);

        final HttpResponse<TravelSolution[]> response = Unirest
                .get(apiEndpoint)
                .asObject(TravelSolution[].class);
        if (response.getStatus() != 200) {
            throw new TrenitaliaResponseException(response);
        }
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

}
