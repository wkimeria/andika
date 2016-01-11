class CreateStories < ActiveRecord::Migration
  def change
    create_table :stories do |t|

      t.timestamps null: false
      t.integer :participant_id
      t.integer :phrase_length , :null => false, :default => 140
      t.integer :quorum, :null => false
      t.boolean :started, :null => false, :default => false
      t.boolean :completed, :null => false, :default => false
      t.integer :length, :null => false, :default => 20
      t.string :uri, :null => false
    end
  end
end
