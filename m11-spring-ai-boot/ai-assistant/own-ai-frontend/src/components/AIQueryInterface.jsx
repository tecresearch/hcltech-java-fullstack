import React, { useState, useEffect } from 'react';
import styled, { createGlobalStyle } from 'styled-components';
import { chat } from './api';
 
// Global styles for a modern look
const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }
  
  body {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    min-height: 100vh;
    padding: 20px;
  }
`;
 
const Container = styled.div`
  max-width: 900px;
  margin: 0 auto;
  background: rgba(255, 255, 255, 0.95);
  border-radius: 20px;
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
  overflow: hidden;
  display: flex;
  flex-direction: column;
  height: calc(100vh - 40px);
`;
 
const Header = styled.header`
  background: linear-gradient(90deg, #4a54e1, #8a2be2);
  color: white;
  padding: 25px;
  text-align: center;
  
  h1 {
    font-weight: 600;
    font-size: 2.2rem;
    margin-bottom: 5px;
  }
  
  p {
    opacity: 0.9;
    font-size: 1.1rem;
  }
`;
 
const ChatContainer = styled.div`
  display: flex;
  flex: 1;
  overflow: hidden;
`;
 
const Sidebar = styled.div`
  width: 250px;
  background: #f8f9fa;
  border-right: 1px solid #e9ecef;
  padding: 20px;
  overflow-y: auto;
  
  h3 {
    margin-bottom: 15px;
    color: #495057;
    font-weight: 600;
  }
`;
 
const HistoryItem = styled.div`
  padding: 12px;
  margin-bottom: 10px;
  background: white;
  border-radius: 10px;
  cursor: pointer;
  box-shadow: 0 2px 5px rgba(0,0,0,0.05);
  transition: all 0.2s;
  
  &:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  }
  
  p {
    font-size: 0.9rem;
    color: #6c757d;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
`;
 
const MainContent = styled.div`
  flex: 1;
  display: flex;
  flex-direction: column;
`;
 
const MessagesContainer = styled.div`
  flex: 1;
  padding: 25px;
  overflow-y: auto;
  background: #fff;
`;
 
const Message = styled.div`
  margin-bottom: 25px;
  display: flex;
  flex-direction: column;
  align-items: ${props => props.isUser ? 'flex-end' : 'flex-start'};
`;
 
const MessageBubble = styled.div`
  max-width: 70%;
  padding: 15px 20px;
  border-radius: 20px;
  background: ${props => props.isUser ? 'linear-gradient(90deg, #667eea, #764ba2)' : '#f1f3f5'};
  color: ${props => props.isUser ? 'white' : '#212529'};
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  line-height: 1.5;
  
  pre {
    background: rgba(0, 0, 0, 0.1);
    padding: 10px;
    border-radius: 8px;
    overflow-x: auto;
    margin: 10px 0;
  }
  
  code {
    font-family: 'Fira Code', monospace;
    font-size: 0.9rem;
  }
`;
 
const InputContainer = styled.div`
  padding: 20px;
  border-top: 1px solid #e9ecef;
  background: #f8f9fa;
`;
 
const InputForm = styled.form`
  display: flex;
  gap: 15px;
`;
 
const InputField = styled.input`
  flex: 1;
  padding: 15px 20px;
  border: none;
  border-radius: 50px;
  font-size: 1rem;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  
  &:focus {
    outline: none;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
  }
`;
 
const SubmitButton = styled.button`
  padding: 0 25px;
  border: none;
  border-radius: 50px;
  background: linear-gradient(90deg, #4a54e1, #8a2be2);
  color: white;
  font-weight: 600;
  cursor: pointer;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  transition: all 0.3s;
  
  &:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
  }
  
  &:active {
    transform: translateY(0);
  }
  
  &:disabled {
    background: #adb5bd;
    cursor: not-allowed;
  }
`;
 
const LoadingDots = styled.div`
  display: inline-flex;
  
  div {
    width: 8px;
    height: 8px;
    border-radius: 50%;
    background: #6c757d;
    margin: 0 3px;
    animation: bounce 1.5s infinite ease-in-out both;
    
    &:nth-child(1) { animation-delay: -0.32s; }
    &:nth-child(2) { animation-delay: -0.16s; }
  }
  
  @keyframes bounce {
    0%, 80%, 100% { transform: scale(0); }
    40% { transform: scale(1); }
  }
`;
 
const AIQueryInterface = () => {
  const [prompt, setPrompt] = useState('');
  const [conversation, setConversation] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [history, setHistory] = useState([]);
 
const handleSubmit = async (e) => {
    e.preventDefault();
    if (!prompt.trim() || isLoading) return;
 
    const userMessage = { text: prompt, isUser: true };
    setConversation(prev => [...prev, userMessage]);
    setPrompt('');
    setIsLoading(true);
 
    try {
     
      const BASE_URL=`http://localhost:8080/ai?q=`;
      const response = await fetch(`${BASE_URL}${encodeURIComponent(prompt)}`);
      
      if (!response.ok) {
        throw new Error(`Server returned ${response.status}`);
      }
      
      const data = await response.json();
      console.log(data);
      // Accessing the result directly from the returned data
      const aiResponse = { text: data.result || 'No response', isUser: false };
      
      setConversation(prev => [...prev, aiResponse]);
      setHistory(prev => [prompt, ...prev.slice(0, 9)]); // Keep last 10 prompts
    } catch (error) {
      console.error('Error fetching AI response:', error);
      const errorMessage = { 
        text: `Sorry, I encountered an error: ${error.message}. Please make sure the server is running on localhost:8080.`, 
        isUser: false 
      };
      setConversation(prev => [...prev, errorMessage]);
    } finally {
      setIsLoading(false);
    }
  };

 
  const formatResponse = (text) => {
    // Simple formatting for code blocks
    if (text.includes('```')) {
      const parts = text.split('```');
      return parts.map((part, index) => {
        if (index % 2 === 1) {
          return <pre key={index}><code>{part}</code></pre>;
        }
        return part;
      });
    }
    return text;
  };
 
  const loadHistoryItem = (item) => {
    setPrompt(item);
  };
 
  return (
    <>
      <GlobalStyle />
      <Container>
        <Header>
          <h1>Tecresearch Assistant</h1>
          <p>Ask anything and get intelligent responses</p>
          <p>Developed by Mr.Brijesh (Software Engineer)</p>
        </Header>
        
        <ChatContainer>
          <Sidebar>
            <h3>Recent Queries</h3>
            {history.length === 0 ? (
              <p>No recent queries</p>
            ) : (
              history.map((item, index) => (
                <HistoryItem key={index} onClick={() => loadHistoryItem(item)}>
                  <p>{item}</p>
                </HistoryItem>
              ))
            )}
          </Sidebar>
          
          <MainContent>
            <MessagesContainer>
              {conversation.length === 0 && !isLoading ? (
                <div style={{ textAlign: 'center', color: '#6c757d', marginTop: '50px' }}>
                  <h2>Welcome to AI Assistant</h2>
                  <p>Start a conversation by typing a query below</p>
                </div>
              ) : (
                conversation.map((msg, index) => (
                  <Message key={index} isUser={msg.isUser}>
                    <MessageBubble isuser={msg.isUser}>
                      {formatResponse(msg.text)}
                    </MessageBubble>
                  </Message>
                ))
              )}
              
              {isLoading && (
                <Message>
                  <MessageBubble>
                    <LoadingDots>
                      <div></div>
                      <div></div>
                      <div></div>
                    </LoadingDots>
                  </MessageBubble>
                </Message>
              )}
            </MessagesContainer>
            
            <InputContainer>
              <InputForm onSubmit={handleSubmit}>
                <InputField
                  type="text"
                  value={prompt}
                  onChange={(e) => setPrompt(e.target.value)}
                  placeholder="Ask me anything..."
                  disabled={isLoading}
                />
                <SubmitButton type="submit" disabled={isLoading}>
                  Send
                </SubmitButton>
              </InputForm>
            </InputContainer>
          </MainContent>
        </ChatContainer>
      </Container>
    </>
  );
};
 
export default AIQueryInterface;
 