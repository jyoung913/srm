/**
 * Created by Jack.Yang on 8/13/2015.
 */
import java.util.*;
import java.io.*;
public class CapCityTsv {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\capcity\\raw.tsv")));
        String line;

        StringBuilder iceOutput = new StringBuilder();
        StringBuilder gloOutput = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] segments = line.split("\t");
            //ICE
            if (segments.length > 5 && (segments[3].length() > 1 || segments[4].length() > 1 || segments[5].length() > 1)) {
                iceOutput.append("new Market { Name = \"" + segments[1] + "\", ");
                if (segments[0].length() > 1) iceOutput.append("DefinedLocation = new Location { Description = \"" + segments[0] + "\" },");
                iceOutput.append(" Commodities = new List<Commodity> {");
                if (segments[3].length() > 1) {
                   iceOutput.append("new Commodity { CommodityType = CommodityType.Index, Symbol = \"" + segments[3] + "\" }, ");
                }
                if (segments[4].length() > 1) {
                    iceOutput.append("new Commodity { CommodityType = CommodityType.Basis, Symbol = \"" + segments[4] + "\" }, ");
                }
                if (segments[5].length() > 1) {
                    iceOutput.append("new Commodity { CommodityType = CommodityType.Swing, Symbol = \"" + segments[5] + "\" }, ");
                }
                // remove trailing comma
                iceOutput.setLength(iceOutput.length() - 2);
                iceOutput.append(" } },\n");
            }

            //Globex
            if (segments.length > 10 && (segments[7].length() > 1 || segments[8].length() > 1 || segments[9].length() > 1 || segments[10].length() > 1)) {
                gloOutput.append("new Market { Name = \"" + segments[1] + "\", ");
                if (segments[0].length() > 1) gloOutput.append("DefinedLocation = new Location { Description = \"" + segments[0] + "\" },");
                gloOutput.append(" Commodities = new List<Commodity> {");
                if (segments[7].length() > 1) {
                    gloOutput.append("new Commodity { CommodityType = CommodityType.Basis, Symbol = \"" + segments[7] + "\" },");
                }
                if (segments[8].length() > 1) {
                    gloOutput.append("new Commodity { CommodityType = CommodityType.Swing, Symbol = \"" + segments[8] + "\" },");
                }
                if (segments[9].length() > 1) {
                    gloOutput.append("new Commodity { CommodityType = CommodityType.Fixed, Symbol = \"" + segments[9] + "\" },");
                }
                if (segments[10].length() > 1) {
                    gloOutput.append("new Commodity { CommodityType = CommodityType.Index, Symbol = \"" + segments[10] + "\" },");
                }
                // remove trailing comma
                gloOutput.setLength(gloOutput.length() - 1);
                gloOutput.append(" } },\n");
            }
        }
        reader.close();
        System.out.print(iceOutput.toString());
        System.out.println("\n\n");
        System.out.print(gloOutput.toString());

    }
}
