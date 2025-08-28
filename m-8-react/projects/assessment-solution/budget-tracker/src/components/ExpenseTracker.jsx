import React, { useState } from 'react'
import IncomeForm from './IncomeForm'
import ExpenseForm from './ExpenseForm'
import Summary from './Summary'

const ExpenseTracker = () => {
    const [income,setIncome]=useState(0);
    const [expense,setExpense]=useState(0);
    const balance=income-expense;
   
  return (
    <div>
      <IncomeForm income={income} setIncome={setIncome}/>
      <ExpenseForm income={income} expense={expense} setExpense={setExpense} />
      <Summary income={income} expense={expense} balance={balance}/>
    </div>
  )
}

export default ExpenseTracker
