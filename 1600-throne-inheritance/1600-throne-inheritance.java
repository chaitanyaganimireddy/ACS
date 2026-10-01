class ThroneInheritance {
    class Person {
        String name;
        boolean alive;
        List<Person> children;

        Person(String name) {
            this.name = name;
            this.alive = true;
            this.children = new ArrayList<>();
        }
    }

    private Person king;
    private Map<String, Person> people;

    public ThroneInheritance(String kingName) {
        people = new HashMap<>();
        king = new Person(kingName);
        people.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = people.get(parentName);
        Person child = new Person(childName);

        parent.children.add(child);
        people.put(childName, child);
    }

    public void death(String name) {
        people.get(name).alive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(Person person, List<String> order) {
        if (person.alive) {
            order.add(person.name);
        }

        for (Person child : person.children) {
            dfs(child, order);
        }
    }
}