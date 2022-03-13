
package trenitalia.response.objects.travel.solution;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TravelSolution {

    @SerializedName("idsolution")
    @Expose
    private String idsolution;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("departuretime")
    @Expose
    private Long departuretime;
    @SerializedName("arrivaltime")
    @Expose
    private Long arrivaltime;
    @SerializedName("minprice")
    @Expose
    private Double minprice;
    @SerializedName("optionaltext")
    @Expose
    private Object optionaltext;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("changesno")
    @Expose
    private Integer changesno;
    @SerializedName("bookable")
    @Expose
    private Boolean bookable;
    @SerializedName("saleable")
    @Expose
    private Boolean saleable;
    @SerializedName("trainlist")
    @Expose
    private List<Train> trainlist = null;
    @SerializedName("onlycustom")
    @Expose
    private Boolean onlycustom;
    @SerializedName("extraInfo")
    @Expose
    private List<Object> extraInfo = null;
    @SerializedName("showSeat")
    @Expose
    private Boolean showSeat;
    @SerializedName("specialOffer")
    @Expose
    private Object specialOffer;
    @SerializedName("transportMeasureList")
    @Expose
    private List<Object> transportMeasureList = null;
    @SerializedName("originalPrice")
    @Expose
    private Double originalPrice;

}
