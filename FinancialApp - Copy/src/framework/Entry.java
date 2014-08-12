/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework;

import java.util.Date;

/**
 *
 * @author mkong
 */
public class Entry implements IEntry{
    private double amount;
    private Date date; 
    private String type;

    public Entry() {
    }
    
    public Entry(double amount, Date date, String type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
