context('Todo', () => {
  it('should see todo page', () => {
    cy.visit("/")
    cy.contains("Hello World")
  })
})
