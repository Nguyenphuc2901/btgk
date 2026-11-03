class Player
{
    private String tenPlayer;
    private BanCo BanCo;
    private Ship[] tauDs;
    private KetQuaBan[][] luoiBan;
    public Player(String tenPlayer)
    {
        this.tenPlayer=tenPlayer;
        this.BanCo=new BanCo();
        this.tauDs=new Ship[5];
        this.luoiBan = new KetQuaBan[10][10];
        tauDs[0]=new tauTuanTra();
        tauDs[1]=new tauChien();
        tauDs[2]=new tauKhuTruc();
        tauDs[3]=new tauNgam();
        tauDs[4]=new tauTuanTra();
    }
    public void datTau()
    {
        for(int i=0;i<tauDs.length;i++)
        {
            Ship tau=tauDs[i];
            while(true)
            {
                System.out.println("Dat "+tau.getTenTau()+"(Kich thuoc "+tau.getKichThuoc()+")");
                System.out.print("Nhap hang (0-9): ");
                int x=NhapDuLieu.sc.nextInt();
                System.out.print("Nhap cot (0-9): ");
                int y=NhapDuLieu.sc.nextInt();
                System.out.print("Nhap huong (0: ngang, 1: doc): ");
                int huong=NhapDuLieu.sc.nextInt();
                if(BanCo.datTau(tau, x, y, huong))
                {
                    BanCo.hienThiBanCo();
                    break;
                }
                System.out.println("Vi tri khong hop le!");
            }
        }
    }
    public KetQuaBan ban(Player doiThu, int x, int y) 
    {
        if (x < 0 || x >= 10 || y < 0 || y >= 10) return null;
        if (luoiBan[x][y]!=null) return null;
        KetQuaBan kq = doiThu.BanCo.nhanPhatBan(x, y);
        if (kq != null) luoiBan[x][y] = kq;
        return kq;
    }
    public void hienThiBanCoMinh()
    {
        BanCo.hienThiBanCo();
    }
    public void hienThiBanCoDoiThu(Player doiThu)
    {
        doiThu.getBanCo().hienThiBanCoBiChe();
    }
    public int demSoTauConLai()
    {
        int dem=0;
        for(int i=0;i<tauDs.length;i++)
        {
            if(!tauDs[i].biPhaHuy()) dem++;
        }
        return dem;
    }
    public boolean kiemTraThua()
    {
        return demSoTauConLai()==0;
    }
    public String getTenPlayer()
    {
        return tenPlayer;
    }
    public BanCo getBanCo()
    {
        return BanCo;
    }
    public Ship[] getTauDs()
    {
        return tauDs;
    }
}
