package trenitalia;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import trenitalia.exceptions.TrenitaliaEmptyArgumentException;
import trenitalia.response.objects.AutocompletedStation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Trenitalia {

    public List<String> autocompleteStations(String city) {
        if (city.isEmpty()) {
            throw new TrenitaliaEmptyArgumentException();
        }
        String apiEndpoint = String.format("https://www.lefrecce.it/msite/api/geolocations/locations?name=%s", city);

        final HttpResponse<AutocompletedStation[]> response = Unirest.get(apiEndpoint)
                .asObject(AutocompletedStation[].class);

        final List<String> stationsList = Arrays.stream(response.getBody())
                .map(AutocompletedStation::getName)
                .collect(Collectors.toList());
        return stationsList;
    }
}
