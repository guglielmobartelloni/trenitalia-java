
package trenitalia.response.objects.travel.solution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Train {

    @SerializedName("trainidentifier")
    @Expose
    private String trainidentifier;
    @SerializedName("trainacronym")
    @Expose
    private String trainacronym;
    @SerializedName("traintype")
    @Expose
    private String traintype;
    @SerializedName("pricetype")
    @Expose
    private String pricetype;

    public String getTrainidentifier() {
        return trainidentifier;
    }

    public void setTrainidentifier(String trainidentifier) {
        this.trainidentifier = trainidentifier;
    }

    public String getTrainacronym() {
        return trainacronym;
    }

    public void setTrainacronym(String trainacronym) {
        this.trainacronym = trainacronym;
    }

    public String getTraintype() {
        return traintype;
    }

    public void setTraintype(String traintype) {
        this.traintype = traintype;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

}
