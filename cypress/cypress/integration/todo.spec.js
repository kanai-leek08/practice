context('Todo', () => {
  it('should see todo page', () => {
    cy.visit("/")
    cy.get("#input").type("clean room");
    cy.contains("登録").click()
    cy.contains("clean room")
  })
})
