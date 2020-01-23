package kata5;

class People {
    private final String name;
    private final String apellido;
    private final String departamento;

    public People(String name, String apellido, String departamento) {
        this.name = name;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    
}
