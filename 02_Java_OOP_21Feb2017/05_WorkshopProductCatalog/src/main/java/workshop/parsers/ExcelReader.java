package workshop.parsers;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import workshop.constants.AppConstants;
import workshop.enums.Excel;
import workshop.models.Product;
import workshop.parsers.interfaces.Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static workshop.constants.ProductConstants.*;

public class ExcelReader implements Reader {

    public static final String INCORRECT_DATE_FORMAT = "Incorrect date format.";

    @Override
    public Set<Product> read(File file, Map<Integer, String> mappings) throws IOException {

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        String extension = "";
        int lastDotIndex = file.getName().lastIndexOf(".");
        if (lastDotIndex != -1) {
            extension = file.getName().substring(lastDotIndex + 1);
        }

        switch (Excel.valueOf(extension.toUpperCase())) {
            case XLSX:
                workbook = new XSSFWorkbook(inputStream);
                break;
            case XLS:
                workbook = new HSSFWorkbook(inputStream);
                break;
        }

        Sheet sheet = workbook.getSheetAt(0);
        Set<Product> products = new HashSet<>();

        for (Row row : sheet) {

            if (row.getRowNum() == 0) {
                continue;
            }

            Product currentProduct = new Product();

            mappings.entrySet().forEach(product -> {

                switch (product.getValue()) {

                    case ID:
                        int id = (int) Double.parseDouble(row.getCell(product.getKey()).toString());
                        currentProduct.setId(id);
                        break;
                    case DESCRIPTION:
                        currentProduct.setDescription(row.getCell(product.getKey()).toString());
                        break;
                    case TYPE:
                        currentProduct.setProductType(row.getCell(product.getKey()).toString());
                        break;
                    case WEIGHT_TYPE:
                        currentProduct.setWeightType(row.getCell(product.getKey()).toString());
                        break;
                    case WEIGHT_VALUE:
                        currentProduct.setWeightValue(Double.parseDouble(row.getCell(product.getKey()).toString()));
                        break;
                    case BRAND_NAME:
                        currentProduct.setBrandName(row.getCell(product.getKey()).toString());
                        break;
                    case BRAND_COUNTRY:
                        currentProduct.setBrandCountry(row.getCell(product.getKey()).toString());
                        break;
                    case NAME:
                        currentProduct.setProductName(row.getCell(product.getKey()).toString());
                        break;
                    case PRICE:
                        currentProduct.setProductPrice(Double.parseDouble(row.getCell(product.getKey()).toString()));
                        break;
                    case EXPIRATION_DATE:
                        SimpleDateFormat format = new SimpleDateFormat(AppConstants.DATE_FORMAT_PATTERN, Locale.ROOT);
                        try {
                            String dateString = row.getCell(product.getKey()).toString();
                            currentProduct.setExpirationDate(format.parse(dateString));
                        } catch (ParseException pex) {
                            System.out.println(INCORRECT_DATE_FORMAT);
                        }
                        break;
                }
            });
            products.add(currentProduct);
        }

        return  products;
    }
}
