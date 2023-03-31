package Portfolio.orgStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrgStructureParserImpl implements OrgStructureParser {
    /**
     * Parses csv file with corporate structure
     * @param csvFile file to parse
     * @return reference to a CEO (the only employee who has no boss)
     * @throws IOException if there are any problems with the file to parse
     */
    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        int bossIndex = -1;
        List<String> fullFile = Files.readAllLines(csvFile.toPath());
        List<Employee> fullStructure = new ArrayList<>(Collections.nCopies(fullFile.size() - 1, new Employee()));
        bossIndex = getBossIndex(bossIndex, fullFile, fullStructure);
        //fullStructure.forEach(System.out::println); //тут можно посмотреть полную структуру
        return bossIndex != -1 ? fullStructure.get(bossIndex) : null;
    }

    private static int getBossIndex(int bossIndex, List<String> fullFile, List<Employee> fullStructure) {
        for (int i = 1; i < fullFile.size(); i++) {
            String[] lineSplitted = fullFile.get(i).split(";");
            long id = Long.parseLong(lineSplitted[0]);
            String name = lineSplitted[2];
            String position = lineSplitted[3];
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setPosition(position);
            long boss_id;
            if (lineSplitted[1].equals("")) {
                bossIndex = i - 1;
                employee.setBoss(null);
            } else {
                boss_id = Long.parseLong(lineSplitted[1]);
                employee.setBoss(fullStructure.get((int) boss_id - 1));
                employee.setBossId(boss_id);
                fullStructure.get((int) boss_id - 1).getSubordinate().add(employee);
            }
            fullStructure.set(i - 1, employee);
        }
        return bossIndex;
    }
}