package trenitalia;

import kong.unirest.Unirest;
import trenitalia.exceptions.TrenitaliaEmptyArgumentException;
import trenitalia.response.objects.autocomplete.AutocompletedStation;
import trenitalia.response.objects.travel.solution.TravelSolution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Trenitalia {

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

    public List<TravelSolution> oneWaySolutions(String autoCompletedOriginStation, String autocompletedDestinationStation, LocalDateTime travelSolutionsDateTime, int nAdults, int nChildren, boolean frecceSolutions, boolean regionalOnly) {
        if (false) {
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
        System.out.println(apiEndpoint);

        final List<TravelSolution> travelSolutionList = Arrays.stream(Unirest
                        .get(apiEndpoint)
                        .asObject(TravelSolution[].class)
                        .getBody())
                .collect(Collectors.toList());
        return travelSolutionList;
    }

}
