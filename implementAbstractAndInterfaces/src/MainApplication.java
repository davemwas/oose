public class MainApplication {
    public static void main(String[] args){
        Admin curAdmin = new Admin(1234, "David", "KzWTUVJ7rt");// instantiation
        User curUser = new User(1224, "Luke");
        curAdmin.performOperation(new Update()); // Admin Updates the data.
        curUser.performOperation(new View()); // User can view the data.
    }
}
