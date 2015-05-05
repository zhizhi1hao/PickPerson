package day10.qianfeng.com.pickperson.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/5/4 0004.
 */
public class PositionBodyView {

    private String moduleType;
    private String moduleName;
    private List<PositionBlockView> list;

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<PositionBlockView> getList() {
        return list;
    }

    public void setList(List<PositionBlockView> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PositionBodyView{" +
                "moduleType='" + moduleType + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", list=" + list +
                '}';
    }
}
