package workshop.parsers.interfaces;

import workshop.models.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface Reader {

    Set<Product> read(File file, Map<Integer, String> mappings) throws IOException;
}
