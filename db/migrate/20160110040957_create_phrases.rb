class CreatePhrases < ActiveRecord::Migration
  def change
    create_table :phrases do |t|
      t.integer :story_id
      t.integer :participant_id
      t.timestamps null: false
    end
  end
end
