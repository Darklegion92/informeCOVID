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

import modelo.vo.bases.Base61_65;

public class Datos61 {

	private Workbook workbook;

	public ArrayList<Base61_65> cargar() {

		String nombreArchivo = "61.xlsx";
		String rutaArchivo = "bases/" + nombreArchivo;
		ArrayList<Base61_65> filas = new ArrayList<Base61_65>();
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
				String idVisita = "";
				String observacion = "";
				Date fechaVisita = null;
				if (i > 0) {
					while (cellIterator.hasNext()) {
						Cell cell = (Cell) cellIterator.next();
						String contenidoCelda = formatter.formatCellValue(cell);

						if (j == 1) {
							idVisita = contenidoCelda;
						}
						if (j == 2) {
							try {
								fechaVisita = formato.parse(contenidoCelda);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
						if (j == 14) {
							documento = contenidoCelda;
						}
						if (j == 87) {
							observacion = contenidoCelda;
						}
						j++;
					}
					Base61_65 fila = new Base61_65(documento, idVisita, observacion, fechaVisita);

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
