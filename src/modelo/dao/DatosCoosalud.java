package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modelo.vo.bases.BaseCoosalud;

public class DatosCoosalud {

	private Workbook workbook;

	public ArrayList<BaseCoosalud> cargar() {

		String nombreArchivo = "COOSALUD.xlsx";
		String rutaArchivo = "bases/" + nombreArchivo;
		ArrayList<BaseCoosalud> filas = new ArrayList<BaseCoosalud>();
		try {
			// se lee el archivo
			FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));

			workbook = new XSSFWorkbook(inputStream);

			// se lee la hoja
			Sheet firstSheet = workbook.getSheetAt(0);

			// se cargan todas la filas
			Iterator<?> iterator = firstSheet.iterator();
			DataFormatter formatter = new DataFormatter();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			int i = 0;
			while (iterator.hasNext()) {
				Row nextRow = (Row) iterator.next();
				Iterator<?> cellIterator = nextRow.cellIterator();
				int j = 0;
				String documento = "";
				String municipio = "";
				String estado = "";
				String carnet="";
				String regimen="";
				Date fechaNacimiento = null;
				if (i > 0) {
					while (cellIterator.hasNext()) {
						Cell cell = (Cell) cellIterator.next();
						String contenidoCelda = formatter.formatCellValue(cell);

						if (j == 2) {
							documento = contenidoCelda;
						}
						if (j == 7) {
							try {
								fechaNacimiento = formato.parse(contenidoCelda);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
						if (j == 12) {
							municipio = contenidoCelda;
						}
						if (j == 28) {
							estado = contenidoCelda;
						}
						if (j == 33) {
							regimen = contenidoCelda;
						}
						if (j == 35) {
							carnet = contenidoCelda;
						}
						j++;
					}
					BaseCoosalud fila = new BaseCoosalud(documento, fechaNacimiento, municipio, estado, carnet, regimen);

					filas.add(fila);
				}
				i++;
			}
			System.err.println(filas.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
