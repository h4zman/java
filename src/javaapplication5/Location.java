/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author Adzeem
 */
public class Location {
    
    private String kosid;
    private String kosname;
    private String kosplace;
    private String kosfloor;
    private byte[] kosimage;
    
    public Location(String kosid,String kosname, String kosplace,
            String kosfloor, byte[] kosimage)
    {
        this.kosid = kosid;
        this.kosname = kosname;
        this.kosplace = kosplace;
        this.kosfloor = kosfloor;
        this.kosimage = kosimage;
    }
    
    public String getKosid()
    {
        return kosid;
    }
    
    public String getKosname()
    {
        return kosname;
    }
    public String getKosplace()
    {
        return kosplace;
    }
    public String getKosfloor()
    {
        return kosfloor;
    }
    public byte[] getKosimage()
    {
        return kosimage;
    }
   
}
