package tp.pp2.rpg.generator.core.importadorHabilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tp.pp2.rpg.generator.core.entidades.DTOHabilidad;

public class ImportadorHabilidadesXLSX implements ImportadorHabilidades {
	//TODO QUIZAS TODA ESTA LOGICA VA EN OTRO PROYECTO
	@Override
	public List<DTOHabilidad> importarHabilidades(File archivoLeer) throws IOException{
		if (archivoLeer.getAbsoluteFile().exists()) {
			File excelFile = archivoLeer;

			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			boolean filaNula;
			Iterator<Row> rowIt = sheet.iterator();
			List<DTOHabilidad> list = new ArrayList<DTOHabilidad>();
			int columnIndex;
			while (rowIt.hasNext()) {
				Row row = rowIt.next();
				filaNula = false;
				if (row.getRowNum() != 0) {
					Iterator<Cell> cellIt = row.cellIterator();
					DTOHabilidad dtoHabilidadGenerado = new DTOHabilidad();
					while (cellIt.hasNext()) {
						Cell cell = cellIt.next();
						columnIndex = cell.getColumnIndex();
						if (cell.toString().isEmpty()) {
							filaNula = true;
							break;
						}
						switch (columnIndex) {
							case 0:
								dtoHabilidadGenerado.setNombre(cell.toString());
								break;
							case 1:
								dtoHabilidadGenerado.setTipo(cell.toString());
								break;
						}
					}
					if (!filaNula)
						list.add(dtoHabilidadGenerado);
					filaNula = false;
				}
			}
			workbook.close();
			fis.close();
			return list;
		}
		return null;
	}

}
