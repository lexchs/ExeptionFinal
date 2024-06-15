package util;

import java.util.zip.DataFormatException;

public class ExeptionDataCatcher extends DataFormatException {
    public ExeptionDataCatcher(String data) {
        super ("Error: " + data);
    }
}