package figure;

public abstract class base {

    protected String figure;
    
    protected base(String figure)
    {
        this.figure = figure;
    }
    public String getFigure()
    {
        return this.figure;
    }
    public void setFigure(String figure)
    {
        this.figure = figure;
    }
    public abstract void undefine();
    
    @Override
    public String toString()
    {
        return "represent\n";
    }
}
