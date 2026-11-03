class TroChoi
{
    private Player player1;
    private Player player2;
    private Player player;
    private boolean ketThuc;
    public void xoaManHinh()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void reset()
    {
        player1=new Player("Nguoi choi 1");
        player2=new Player("Nguoi choi 2");
        player=player1;
        ketThuc=false;
    }
    public TroChoi()
    {
        player1=new Player("Nguoi choi 1");
        player2=new Player("Nguoi choi 2");
        player=player1;
        ketThuc=false;
    }
    public void batDau()
    {
        reset();
        System.out.println("=== DAT TAU NGUOI CHOI 1 ===");
        player1.datTau();
        xoaManHinh();
        System.out.println("=== DAT TAU NGUOI CHOI 2 ===");
        player2.datTau();
        xoaManHinh();
        ketThuc=false;
        player=player1;
    }
    public void chuanbi()
    {
        player=player1;
        ketThuc=false;
    }
    public void choiGame()
    {
       while(!ketThuc)
      {
        Player doiThu;
        if(player==player1) doiThu=player2;
        else doiThu=player1;
        System.out.println("\nLuot cua " + player.getTenPlayer());
        player.hienThiBanCoDoiThu(doiThu);
        int x, y;
        KetQuaBan kq;
        while(true)
        {
            System.out.print("Nhap hang (0-9): ");
            x=NhapDuLieu.sc.nextInt();
            System.out.print("Nhap cot (0-9): ");
            y=NhapDuLieu.sc.nextInt();
            kq=player.ban(doiThu,x,y);
            if(kq!=null) break;
            System.out.println("Toa do khong hop le hoac da ban!");
        }
        if(kq==KetQuaBan.TRUOT)
            System.out.println("💦 Ban truot!");
        else if(kq==KetQuaBan.TRUNG)
            System.out.println("💥 Ban trung tau!");
        else if(kq==KetQuaBan.CHIM)
            System.out.println("🚢 Ban da danh chim tau!");

        System.out.println("Ban co sau khi ban:");
        player.hienThiBanCoDoiThu(doiThu);

        if(doiThu.kiemTraThua()) {
            ketThuc = true;
            break;
        }
        if(KetQuaBan.TRUOT==kq)
        {
            doiLuot();
            System.out.println("Chuyen sang luot nguoi choi tiep theo!");
            System.out.println("Hay doi luoi cho "+ player.getTenPlayer());
            System.out.println("Nhan Enter de tiep tuc...");
            NhapDuLieu.sc.nextLine();
            NhapDuLieu.sc.nextLine();
            xoaManHinh();
        }
       }
    }
    public void doiLuot() 
    {
        if (player==player1) player=player2;
        else  player=player1;
    }
    public Player kiemTraNguoiThang() 
    {
        if (player1.kiemTraThua()) return player2;
        if (player2.kiemTraThua()) return player1;
        return null;
    }
    public void hienThiKetQua() 
    {
        Player nguoiThang=kiemTraNguoiThang();
        if(nguoiThang != null)
        {
            System.out.println("\033[33m");
            System.out.println();
            System.out.println("██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗");
            System.out.println("██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝");
            System.out.println("██║   ██║██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ ");
            System.out.println("╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  ");
            System.out.println(" ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   ");
            System.out.println("  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ");
            System.out.println();
            System.out.println("========================================================");
            System.out.println("             ⚓ THE BATTLE HAS BEEN WON! ⚓");
            System.out.println("========================================================");
            System.out.println("\033[0m");

            System.out.println();
            System.out.println("       👑 NHÀ VÔ ĐỊCH: " + nguoiThang.getTenPlayer());
            System.out.println("       🏆 CHIẾN THẮNG THUỘC VỀ BẠN!");
            System.out.println();
        }
        else  System.out.println("Tro choi chua ket thuc!");
    }
    
}
