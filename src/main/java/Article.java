public class Article {
    private int id_art;
    private String name;
    private String code;
    private String userName;
    private String guid;

    public Article(int id_art, String name, String code, String userName, String guid) {
        this.id_art = id_art;
        this.name = name;
        this.code = code;
        this.userName = userName;
        this.guid = guid;
    }

    public int getId_art() {
        return id_art;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getUserName() {
        return userName;
    }

    public String getGuid() {
        return guid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id_art=" + id_art +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", userName='" + userName + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
