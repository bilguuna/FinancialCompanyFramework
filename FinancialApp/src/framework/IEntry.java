package framework;

import java.util.Date;

public interface IEntry {
    public double getAmount();
    public void setAmount(double amount);
    public Date getDate();
    public void setDate(Date date);
    public String getType();
    public void setType(String type);
    
}
