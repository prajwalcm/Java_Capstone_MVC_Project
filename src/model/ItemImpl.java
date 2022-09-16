package model;

/**
 * Represents the Items in the world that can be used to attack.
 */
public class ItemImpl implements Item {
  private int id;
  private String name;
  private int damage;
  private int containingRoomIndex;

  /**
   * Initializes the item object to the set of parameters passed.
   *
   * @param id id of the item, based on 0 based indexing in the items list.
   * @param name name of the item.
   * @param damage damage done by the item.
   * @param containingRoomIndex index of the room that contains this item.
   * @throws IllegalArgumentException for invalid parameter values.
   */
  public ItemImpl(int id, String name, int damage, int containingRoomIndex)
          throws IllegalArgumentException {
    if (id < 0) {
      throw new IllegalArgumentException("Item id cannot be negative.");
    }

    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Item name cannot be null or item name cannot be"
              + " an empty string.");
    }

    if (containingRoomIndex < 0) {
      throw new IllegalArgumentException("Containing room index cannot be negative.");
    }

    if (damage < 0) {
      throw new IllegalArgumentException("Damage cannot be negative.");
    }

    this.id = id;
    this.name = name;
    this.damage = damage;
    this.containingRoomIndex = containingRoomIndex;
  }

  @Override
  public int getContainingRoomIndex() {
    return this.containingRoomIndex;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public int getDamage() {
    return this.damage;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(this.containingRoomIndex)
            .append(" ")
            .append(this.damage)
            .append(" ")
            .append(this.name);

    return stringBuilder.toString();
  }

}
