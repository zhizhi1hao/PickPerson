package day10.qianfeng.com.pickperson.bean;

/**
 * Created by Administrator on 2015/5/4 0004.
 */
public class PositionBlockView {
private String imgName;
    private String skipId;
    private String imgURL;

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getSkipId() {
        return skipId;
    }

    public void setSkipId(String skipId) {
        this.skipId = skipId;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "PositionTopView{" +
                "imgName='" + imgName + '\'' +
                ", skipId='" + skipId + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}

