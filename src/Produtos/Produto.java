package Produtos;

public class Produto {
    String NomeProduto;
    double Preço;
    int Quantidade;
    int Id;
    public Produto(){}
    public Produto(String nomeProduto,double preço,int quantidade,int id)
    {
        this.NomeProduto=nomeProduto;
        this.Preço=preço;
        this.Quantidade=quantidade;
        this.Id=id;
    }
    public String GetNome()
    {
        return (this.NomeProduto);
    }
    public double GetPreço()
    {
        return (this.Preço);
    }
    public int GetQuantidade()
    {
        return (this.Quantidade);
    }
    public int GetId()
    {

        return (this.Id);
    }
    public void SetNome(String nomeProduto)
    {
        this.NomeProduto=nomeProduto;
    }
    public void Setpreço(double preço)
    {
        this.Preço=preço;
    }
    public void SetQuantidade(int quantidade)
    {
        this.Quantidade=quantidade;
    }
    public void SetId(int id)
    {
        this.Id=id;
    }
}



