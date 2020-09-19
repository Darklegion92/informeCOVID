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

import modelo.vo.bases.BaseProm_Sana;

public class DatosAtencionesSana {

	private Workbook workbook;

	public ArrayList<BaseProm_Sana> cargar() {

		String nombreArchivo = "SANAATENCIONES.xlsx";
		String rutaArchivo = "bases/" + nombreArchivo;
		ArrayList<BaseProm_Sana> filas = new ArrayList<BaseProm_Sana>();
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
				Date fechaConsulta = null;
				if (i > 0) {
					while (cellIterator.hasNext()) {
						Cell cell = (Cell) cellIterator.next();
						String contenidoCelda = formatter.formatCellValue(cell);
						
						if (j == 0) {
							documento = contenidoCelda;
						}
						if (j == 17) {
							try {
							fechaConsulta = formato.parse(contenidoCelda);
							}catch (Exception e) {
								
							}
						}
						j++;
					}
					BaseProm_Sana fila = new BaseProm_Sana(documento, fechaConsulta);
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
