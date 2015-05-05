package day10.qianfeng.com.pickperson.bean;

/**
 * Created by Administrator on 2015/5/3 0003.
 */
public class NearPerson {
    private String nickName;
    private String age;
    private String sex;
    private String distance;
    private String iconUrl;
    private String detail;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "NearPerson{" +
                "nickName='" + nickName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", distance='" + distance + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
