package Portfolio.orgStructure;

import java.io.File;
import java.io.IOException;

public class OrgStructureTest {
    public static void main(String[] args) throws IOException {
        OrgStructureParser parser = new OrgStructureParserImpl();
        Employee boss = parser.parseStructure(new File("structure.csv"));
        System.out.println(boss);
    }
}
