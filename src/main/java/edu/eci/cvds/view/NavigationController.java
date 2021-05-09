package edu.eci.cvds.view;

import java.io.IOException;
import java.io.Serializable;  

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

@ManagedBean(name = "navigationController", eager = true)
@SessionScoped
public class NavigationController implements Serializable {

    private boolean showOffers = true;

    public String loginScreen() {
        return "login.xhtml";
    }

    public String Home(){
        return "home.xhtml";
    }

    public String showMessage(String msg){
        return null;
    }


    public boolean isShowOffers() {
        return this.showOffers;
    }

    public boolean getShowOffers() {
        return this.showOffers;
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());

        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }

    public void setShowOffers(boolean showOffers) {
        try {
            this.showOffers = showOffers;
            FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}