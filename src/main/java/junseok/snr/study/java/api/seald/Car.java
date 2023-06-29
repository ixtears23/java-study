package junseok.snr.study.java.api.seald;

public abstract sealed class Car permits Van, Sedan  {
    public abstract void start();
}
