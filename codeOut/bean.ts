export default class example {

    public static getConfigName(): string {
        return "example";
    }

    constructor() {
    }
    /**
     *  id
     */
    private id: number;
    /**
     *  名称
     */
    private name: string;
    /**
     *  值
     */
    private value: number;

    public getId(): number {
        return this.id;
    }
    public setId(id: number) {
        this.id = id;
    }

    public getName(): string {
        return this.name;
    }
    public setName(name: string) {
        this.name = name;
    }

    public getValue(): number {
        return this.value;
    }
    public setValue(value: number) {
        this.value = value;
    }


}