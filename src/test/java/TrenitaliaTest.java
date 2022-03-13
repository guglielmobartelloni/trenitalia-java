import org.junit.Before;
import org.junit.Test;
import trenitalia.Trenitalia;
import trenitalia.exceptions.TrenitaliaEmptyArgumentException;

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
}