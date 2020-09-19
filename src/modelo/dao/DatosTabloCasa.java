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

import modelo.vo.bases.BaseTablo;

public class DatosTabloCasa {

	private Workbook workbook;

	public ArrayList<BaseTablo> cargar() {

		String nombreArchivo = "TABLOCONFIRMADOS.xlsx";
		String rutaArchivo = "bases/" + nombreArchivo;
		ArrayList<BaseTablo> filas = new ArrayList<BaseTablo>();
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
				String grupoRiesgo = "";
				String lugarAislamiento = "";
				String estadoSalud = "";
				String fuenteMuerte = "";
				String lugarMuerte = "";
				Date fechaMuerte = null;
				if (i > 0) {
					while (cellIterator.hasNext()) {
						Cell cell = (Cell) cellIterator.next();
						String contenidoCelda = formatter.formatCellValue(cell);

						if (j == 3) {
							documento = contenidoCelda;
						}
						if (j == 7) {
							grupoRiesgo = contenidoCelda;
						}
						if (j == 8) {
							estadoSalud = contenidoCelda;
						}
						if (j == 9) {
							lugarAislamiento = contenidoCelda;
						}
						if (j == 10) {
							estadoSalud = contenidoCelda;
						}
						if (j == 13) {
						
							try {
								fechaMuerte = formato.parse(contenidoCelda);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}						
						if (j == 14) {
							fuenteMuerte = contenidoCelda;
						}						
						if (j == 15) {
							lugarMuerte = contenidoCelda;
						}
						j++;
					}
					BaseTablo fila = new BaseTablo(documento, grupoRiesgo, lugarAislamiento, estadoSalud, fechaMuerte,
							fuenteMuerte, lugarMuerte);
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
