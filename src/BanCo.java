class BanCo
{
    private Ship[][] luoiTau;
    private KetQuaBan[][] luoiKetQuaBan;
    private int kichThuoc=5;
    public BanCo()
    {
        luoiTau= new Ship[kichThuoc][kichThuoc];
        luoiKetQuaBan=new KetQuaBan[kichThuoc][kichThuoc];
        for(int i=0;i<kichThuoc;i++)
            for(int j=0;j<kichThuoc;j++) luoiKetQuaBan[i][j]=null;
    }
    public boolean datTau(Ship tau,int x,int y,int huong)
    {
        int dai=tau.getKichThuoc();
        for(int i=0;i<dai;i++)
        {
            int hang=x;
            int cot=y;
            if(huong==0) cot+=i;
            else hang+=i;
            if(cot<0||cot>=kichThuoc||hang>=kichThuoc||hang<0) return false;
            if(luoiTau[hang][cot]!=null) return false;
        }
        tau.datTau(y, x, huong==0);
        for(int i=0;i<dai;i++)
        {
            int hang=x;
            int cot=y;
            if(huong==0) cot+=i;
            else hang+=i;
            luoiTau[hang][cot]=tau;
        }
        return true;
    }
    public void hienThiBanCo()
    {
        for(int i=0;i<kichThuoc;i++)
        {
            for(int j=0;j<kichThuoc;j++)
            {
                if(luoiTau[i][j]==null) System.out.print("~ ");
                else System.out.print("T ");
            }
            System.out.println(); 
        }
    }
    public void hienThiBanCoBiChe()
    {
        System.out.print("      ");
        for(int j=0;j<kichThuoc;j++)  System.out.printf("%-4d",j);
        System.out.println();
        for(int i=0;i<kichThuoc;i++)
        {
            System.out.printf("%-4d",i);
            for(int j=0;j<kichThuoc;j++)
            {
                if(luoiKetQuaBan[i][j] == KetQuaBan.TRUOT) System.out.printf("%-4s","💦");
                else if(luoiKetQuaBan[i][j] == KetQuaBan.TRUNG) System.out.printf("%-4s","💥");
                else if(luoiKetQuaBan[i][j] == KetQuaBan.CHIM) System.out.printf("%-4s","🚢");
                else System.out.printf("%-4s","🌊");
            }
            System.out.println();
        } 
    }
    public KetQuaBan nhanPhatBan(int x,int y)
    {
        if(x<0||x>=kichThuoc||y<0||y>=kichThuoc) return null;
        if(luoiKetQuaBan[x][y]!=null) return null;
        if(luoiTau[x][y]==null)
        {
            luoiKetQuaBan[x][y]=KetQuaBan.TRUOT;
            return KetQuaBan.TRUOT;
        }
        Ship tau=luoiTau[x][y];
        tau.soLan();
        if(tau.biPhaHuy())
        {
            for(int i=0;i<kichThuoc;i++)
                for(int j=0;j<kichThuoc;j++)
                   if(luoiTau[i][j]==tau) luoiKetQuaBan[i][j]=KetQuaBan.CHIM;
            return KetQuaBan.CHIM;
        }
        luoiKetQuaBan[x][y]=KetQuaBan.TRUNG;
        return KetQuaBan.TRUNG;
    }
}