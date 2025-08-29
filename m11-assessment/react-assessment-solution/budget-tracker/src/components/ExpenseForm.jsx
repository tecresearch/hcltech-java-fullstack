import React, { useState } from 'react'

const ExpenseForm = ({ income, expense, setExpense }) => {

    const [localExpense, setLocalExpense] = useState(0);
   
    const addExpenseSubmit = (e) => {
        e.preventDefault();

        const  formData=new FormData(e.target);
        const data=Object.fromEntries(formData);
        console.log(data);
         console.log(formData);

        // Updated condition: Check if income is greater than or equal to total expenses
        const totalExpense=expense + Number(data.expense);
        console.log(totalExpense);
        if (income >= totalExpense) {
            setExpense(Number(expense) + Number(localExpense));
        } else {
            console.log('Insufficient income');
        }

        setLocalExpense('');
    }

    return (
        <div>
            <h4>Expense Form</h4>
            <form onSubmit={addExpenseSubmit}>
                <input type="number" 
                       name="expense" 
                       placeholder='Enter your expense'
                       value={localExpense}
                       onChange={(e) => setLocalExpense(e.target.value)}
                />
                <button type='submit'>Add Expense</button>
            </form>
        </div>
    )
}

export default ExpenseForm;
