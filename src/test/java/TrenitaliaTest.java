import org.junit.Before;
import org.junit.Test;
import trenitalia.Trenitalia;
import trenitalia.exceptions.TrenitaliaEmptyArgumentException;
import trenitalia.exceptions.TrenitaliaResponseException;
import trenitalia.response.objects.travel.solution.TravelSolution;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TrenitaliaTest {

    private Trenitalia trenitalia;

    @Before
    public void setup() {
        this.trenitalia = new Trenitalia();
    }

    @Test
    public void testAutocompleteStationsWithValidCities() {
        assertThat(trenitalia.autocompleteStations("milano"))
                .hasSameElementsAs(List.of("MILANO ( TUTTE LE STAZIONI )",
                        "MILANO AFFORI",
                        "MILANO BOVISA POLITECNICO",
                        "MILANO BRUZZANO",
                        "MILANO CADORNA"));
        assertThat(trenitalia.autocompleteStations("firenze"))
                .hasSameElementsAs(List.of("FIRENZE ( TUTTE LE STAZIONI )",
                        "FIRENZE AEROPORTO",
                        "FIRENZE CAMPO DI MARTE",
                        "FIRENZE CASCINE",
                        "FIRENZE CASTELLO"));
    }

    @Test
    public void testAutocompleteStationsWithInvalidCities() {
        assertThat(trenitalia.autocompleteStations("asdrubale")).isEmpty();
        assertThat(trenitalia.autocompleteStations("pistola")).isEmpty();
    }

    @Test
    public void testAutocompleteStationsWithEmptyArgument() {
        assertThatExceptionOfType(TrenitaliaEmptyArgumentException.class)
                .isThrownBy(() -> trenitalia.autocompleteStations(""));
    }

    @Test
    public void testOneWaySolutionsWithRightParameters() {
        final String milano = trenitalia.autocompleteStations("milano").get(1);
        final String roma = trenitalia.autocompleteStations("roma").get(1);
        final LocalDateTime today = LocalDateTime.now();
        final List<TravelSolution> travelSolutionList = trenitalia.oneWaySolutions(milano, roma, today, 1, 0, false, false);
        assertThat(travelSolutionList).isNotEmpty();
    }

    @Test
    public void testOneWaySolutionsWithWrongParameters() {
        final LocalDateTime today = LocalDateTime.now();
        //Wrong stations (because not autocompleted)
        assertThatExceptionOfType(TrenitaliaResponseException.class)
                .isThrownBy(() -> trenitalia
                        .oneWaySolutions("milano",
                                "milano",
                                today,
                                1,
                                0,
                                false,
                                false))
                .withMessage("Error in the request, response code: 400 with message: Bad Request\n" +
                        "Make sure your parameters are correct");
        assertThatExceptionOfType(TrenitaliaResponseException.class)
                .isThrownBy(() -> trenitalia
                        .oneWaySolutions("MILANO AFFORI",
                                "milano",
                                today,
                                1,
                                0,
                                false,
                                false))
                .withMessage("Error in the request, response code: 400 with message: Bad Request\n" +
                        "Make sure your parameters are correct");

        //Zero adults and children
        assertThatExceptionOfType(TrenitaliaResponseException.class)
                .isThrownBy(() -> trenitalia
                        .oneWaySolutions("MILANO AFFORI",
                                "MILANO BOVISA POLITECNICO",
                                today,
                                0,
                                0,
                                false,
                                false))
                .withMessage("Error in the request, response code: 400 with message: Bad Request\n" +
                        "Make sure your parameters are correct");

        //Wrong date (too old)
        assertThatExceptionOfType(TrenitaliaResponseException.class)
                .isThrownBy(() -> trenitalia
                        .oneWaySolutions("MILANO AFFORI",
                                "MILANO BOVISA POLITECNICO",
                                LocalDateTime.of(2018, 3, 20, 10, 0),
                                1,
                                0,
                                false,
                                false))
                .withMessage("Error in the request, response code: 500 with message: Internal Server Error\n" +
                        "Make sure your parameters are correct");
    }

    @Test
    public void testOneWayTravelWithEmptyOrNullArguments() {
        assertThatExceptionOfType(TrenitaliaEmptyArgumentException.class).isThrownBy(() -> trenitalia.oneWaySolutions(null, null, null, 1, 1, false, false));
        assertThatExceptionOfType(TrenitaliaEmptyArgumentException.class).isThrownBy(() -> trenitalia.oneWaySolutions("", "", LocalDateTime.now(), 1, 1, false, false));
    }
}