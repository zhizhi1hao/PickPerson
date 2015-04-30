package Beans;

/**
 * Created by shang on 2015/4/30.
 */
public class post {
     private String actType;
     private NearBy data;


    public post()
    {}

    public NearBy getData() {
        return data;
    }

    public void setData(NearBy data) {
        this.data = data;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }
}
