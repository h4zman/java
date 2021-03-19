 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author Hazman
 */
public class Timetable {
    
    
    private String kosid;
    private String kosname;
    private String koslect;
    private String kosday;
    private String koskod;
    private String Stime;
    private String Etime;
    
    public Timetable(String kosid,String kosname, String koslect,String kosday,
              String Stime, String Etime)
    {
        this.kosid = kosid;
        this.kosname = kosname;
       
      //  this.kosplace = kosplace;
       // this.kosfloor = kosfloor;
        this.koslect = koslect;
        this.kosday = kosday;
        this.koskod = koskod;
        this.Stime = Stime;
        this.Etime = Etime;
    }
    
    public String getKosid()
    {
        return kosid;
    }
    
    public String getKosname()
    {
        return kosname;
    }
   /* public String getKosplace()
    {
        return kosplace;
    }
    public String getKosfloor()
    {
        return kosfloor;
    }*/
    public String getKosLect()
    {
        return koslect;
    }
    public String getKosKod()
    {
        return koskod;
    }
    public String getStime()
    {
        return Stime;
    }
    public String getEtime()
    {
        return Etime;
    }
    public String getDay()
    {
        return kosday;
    }
}
