package de.wind_erleben.jsonstrukture;

public class SingleSourceObject {
    
    private String name;
    private String unit;
    private int decimals;
    private String color;
    private String graphType;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getDecimals() {
        return decimals;
    }
    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getGraphType() {
        return graphType;
    }
    public void setGraphType(String graphType) {
        this.graphType = graphType;
    }

    @Override
    public String toString() {
        return "SingleSourceObject [name=" + name + ", unit=" + unit + ", decimals=" + decimals + ", color=" + color
                + ", graphType=" + graphType + "]";
    }
}
