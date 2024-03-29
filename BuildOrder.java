public class BuildOrder {
    public static void main(String[] args) {
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = {{'a','d'}, {'f','b'}, {'b','d'}, {'f','a'}, {'d','c'}};
       System.out.println(buildorder(projects, dependencies));
    }

    public static char[] buildorder(char[] projects, char[][] dependencies){
        char[] buildOrder = new char[projects.length];
        StringBuilder temp = new StringBuilder();
        StringBuilder temp1 = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        StringBuilder temp4 = new StringBuilder();
        int count1 = 0;
        int count2 = projects.length-1;
        for (int i = 0; i < dependencies.length; i++){
            for (int j = 0; j < 2; j++){
                temp.append(dependencies[i][j]);
                if (j == 0){
                    temp1.append(dependencies[i][j]);
                }
                else{
                    temp2.append(dependencies[i][j]);
                }
            }
        }


        for (int i = 0; i < projects.length; i++) {
            if (!(temp.toString().contains(String.valueOf(projects[i])))) {
                buildOrder[count1] = projects[i];
                count1++;
            }
            else if (!(temp2.toString().contains(String.valueOf(projects[i])))) {
                buildOrder[count1] = projects[i];
                count1++;
            }
            else if (!(temp1.toString().contains(String.valueOf(projects[i])))) {
                buildOrder[count2] = projects[i];
                count2--;
            }
        }
        for (int i =0; i < buildOrder.length; i++){
            temp4.append(buildOrder[i]);
        }

        for (int i =0; i< temp1.length(); i++){
            if (temp4.toString().contains(String.valueOf(temp1.charAt(i)))){
                buildOrder[count1] = temp2.charAt(i);
                count1++;
            }
            else if (temp4.toString().contains(String.valueOf(temp2.charAt(i)))){
                buildOrder[count2] = temp1.charAt(i);
                count2--;
            }
        }

        return buildOrder;
    }
}
