package repository;

public interface PasswordsRepositoryInterface {

    public void addPass(Integer emailHash, Integer passwordHash);
    public boolean verifyPass(Integer eMailHash, Integer passwordHash);

}
