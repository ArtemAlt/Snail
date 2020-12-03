public class Main {

    public static void main(String[] args) {
        int SizeX = 5;
        int SizeY = 7;
        int currentNum = 1;
        int[][] array = new int[SizeY][SizeX];
        //Заполняем периметр массива по часовой стрелке.
        for (int i = 0; i < SizeX; i++) { // первая строка
            array[0][i] = currentNum;
            currentNum++;
        }
        for (int i = 1; i < SizeY; i++) {   // последний столбец
            array[i][SizeX - 1] = currentNum;
            currentNum++;
        }
        for (int i = SizeX - 2; i >= 0; i--) { // последняя строка
            array[SizeY - 1][i] = currentNum;
            currentNum++;
        }
        for (int i = SizeY - 2; i > 0; i--) { // первый столбец
            array[i][0] = currentNum;
            currentNum++;
        }
        //у нас массив с заполненым периметром остальное нули
        // будем считать шаги и искать где ноль и там будем ставить текущий счетчик
        int insideX = 1;
        int insideY = 1;
        while (currentNum < SizeY * SizeX) { // последнее число улитки
            while (array[insideX][insideY + 1] == 0) {
                array[insideX][insideY] = currentNum;
                currentNum++;
                insideY++;
            }
            while (array[insideX + 1][insideY] == 0) {
                array[insideX][insideY] = currentNum;
                currentNum++;
                insideX++;
            }
            while (array[insideX][insideY - 1] == 0) {
                array[insideX][insideY] = currentNum;
                currentNum++;
                insideY--;
            }
            while (array[insideX - 1][insideY] == 0) {
                array[insideX][insideY] = currentNum;
                currentNum++;
                insideX--;
            }
        }
// проверяем последнюю цифру
        for (int i = 0; i < SizeY; i++) {
            for (int j = 0; j < SizeX; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = currentNum;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

