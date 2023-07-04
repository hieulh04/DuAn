/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lequy
 */
public class ChucVu_Model {

    private String id;
    private String ma;
    private String tencv;

    public ChucVu_Model() {
    }

    public ChucVu_Model(String id, String ma, String tencv) {
        this.id = id;
        this.ma = ma;
        this.tencv = tencv;
    }

    public ChucVu_Model(String ma, String tencv) {

        this.ma = ma;
        this.tencv = tencv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    @Override
    public String toString() {
        return tencv;
    }
    
    

}
