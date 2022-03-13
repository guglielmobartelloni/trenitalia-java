
package trenitalia.response.objects.travel.solution;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public String getIdsolution() {
        return idsolution;
    }

    public void setIdsolution(String idsolution) {
        this.idsolution = idsolution;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Long departuretime) {
        this.departuretime = departuretime;
    }

    public Long getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Long arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Double getMinprice() {
        return minprice;
    }

    public void setMinprice(Double minprice) {
        this.minprice = minprice;
    }

    public Object getOptionaltext() {
        return optionaltext;
    }

    public void setOptionaltext(Object optionaltext) {
        this.optionaltext = optionaltext;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getChangesno() {
        return changesno;
    }

    public void setChangesno(Integer changesno) {
        this.changesno = changesno;
    }

    public Boolean getBookable() {
        return bookable;
    }

    public void setBookable(Boolean bookable) {
        this.bookable = bookable;
    }

    public Boolean getSaleable() {
        return saleable;
    }

    public void setSaleable(Boolean saleable) {
        this.saleable = saleable;
    }

    public List<Train> getTrainlist() {
        return trainlist;
    }

    public void setTrainlist(List<Train> trainlist) {
        this.trainlist = trainlist;
    }

    public Boolean getOnlycustom() {
        return onlycustom;
    }

    public void setOnlycustom(Boolean onlycustom) {
        this.onlycustom = onlycustom;
    }

    public List<Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(List<Object> extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Boolean getShowSeat() {
        return showSeat;
    }

    public void setShowSeat(Boolean showSeat) {
        this.showSeat = showSeat;
    }

    public Object getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(Object specialOffer) {
        this.specialOffer = specialOffer;
    }

    public List<Object> getTransportMeasureList() {
        return transportMeasureList;
    }

    public void setTransportMeasureList(List<Object> transportMeasureList) {
        this.transportMeasureList = transportMeasureList;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

}
