import java.util.Scanner;

class Menu 
{
    private Scanner sc = NhapDuLieu.sc;
    private TroChoi troChoi;

    public Menu() {
        troChoi = new TroChoi();
    }

    public void hienThiMenu() 
    {
        int chon;
        System.out.println("  .--.--.      ,---,.  ,---,                                                  \r\n" + //
                                " /  /    '.  ,'  .' | '  .' \\                                                 \r\n" + //
                                "|  :  /`. /,---.'   |/  ;    '.                                               \r\n" + //
                                ";  |  |--` |   |   .:  :       \\                                              \r\n" + //
                                "|  :  ;_   :   :  |-:  |   /\\   \\                                             \r\n" + //
                                " \\  \\    `.:   |  ;/|  :  ' ;.   :                                            \r\n" + //
                                "  `----.   |   :   .|  |  ;/  \\   \\                                           \r\n" + //
                                "  __ \\  \\  |   |  |-'  :  | \\  \\ ,'                                           \r\n" + //
                                " /  /`--'  '   :  ;/|  |  '  '--'                                             \r\n" + //
                                "'--'.     /|   |    |  :  :                                                   \r\n" + //
                                "  `--'---' |   :   .|  | ,'                                                   \r\n" + //
                                "           |   | ,' `--''      ,----,      ,----,  ,--,                       \r\n" + //
                                "           `----'            ,/   .`|    ,/   .`,---.'|                       \r\n" + //
                                "    ,---,.   ,---,         ,`   .'  :  ,`   .'  |   | :      ,---,. .--.--.   \r\n" + //
                                "  ,'  .'  \\ '  .' \\      ;    ;     /;    ;     :   : |    ,'  .' |/  /    '. \r\n" + //
                                ",---.' .' |/  ;    '.  .'___,/    ,.'___,/    ,'|   ' :  ,---.'   |  :  /`. / \r\n" + //
                                "|   |  |: :  :       \\ |    :     ||    :     | ;   ; '  |   |   .;  |  |--`  \r\n" + //
                                ":   :  :  :  |   /\\   \\;    |.';  ;;    |.';  ; '   | |__:   :  |-|  :  ;_    \r\n" + //
                                ":   |    ;|  :  ' ;.   `----'  |  |`----'  |  | |   | :.':   |  ;/|\\  \\    `. \r\n" + //
                                "|   :     |  |  ;/  \\   \\  '   :  ;    '   :  ; '   :    |   :   .' `----.   \\\r\n" + //
                                "|   |   . '  :  | \\  \\ ,'  |   |  '    |   |  ' |   |  ./|   |  |-, __ \\  \\  |\r\n" + //
                                "'   :  '; |  |  '  '--'    '   :  |    '   :  | ;   : ;  '   :  ;/|/  /`--'  /\r\n" + //
                                "|   |  | ;|  :  :          ;   |.'     ;   |.'  |   ,/   |   |    '--'.     / \r\n" + //
                                "|   :   / |  | ,'          '---'       '---'    '---'    |   :   .' `--'---'  \r\n" + //
                                "|   | ,'  `--''                                          |   | ,'             \r\n" + //
                                "`----'                                                   `----'               ");
        do 
        {
            System.out.println("1. Bat dau game");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    troChoi.batDau();
                    troChoi.choiGame();
                    troChoi.hienThiKetQua();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

        } while (chon != 0);
    }
}
