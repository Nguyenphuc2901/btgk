class Ship
{
    private String tenTau;
    private int kichThuoc;
    private int soLanTrung;
    private boolean ngang;
    private int hang;
    private int cot;
    public Ship(String tenTau,int kichThuoc)
    {
        this.tenTau=tenTau;
        this.kichThuoc=kichThuoc;
        this.soLanTrung=0;
    }
    public String getTenTau()
    {
        return tenTau;
    }
    public int getKichThuoc()
    {
        return kichThuoc;
    }
    public void soLan()
    {
        soLanTrung++;
    }
    public int getHang()
    {
        return hang;
    }
    public int getCot()
    {
        return cot;
    }
    public int getBiTrung()
    {
        return soLanTrung;
    }
    public boolean getNgang()
    {
        return ngang;
    }
    public boolean biPhaHuy()
    {
        return soLanTrung>=kichThuoc;
    }
    public void datTau(int cot,int hang,boolean ngang)
    {
        this.cot=cot;
        this.hang=hang;
        this.ngang=ngang;
    }
}
