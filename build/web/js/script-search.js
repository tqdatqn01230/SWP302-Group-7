function getDocumentWidth() {
    return Math.max(document.documentElement.clientWidth, window.innerWidth || 0);
  };
  
  function getDocumentHeight() {
    return Math.max(document.documentElement.clientHeight, window.innerHeight || 0)
  };
  
  var canvas = document.getElementById('background');
  var context = canvas.getContext('2d');
  
  var vw = canvas.clientWidth,
      vh = canvas.clientHeight;
  
  // resize the canvas to fill browser window dynamically
  window.addEventListener('resize', onResize, false);
  function onResize() {
    vw = canvas.clientWidth;
    vh = canvas.clientHeight;
    resizeCanvas();
  }
  
  function resizeCanvas() {
    canvas.width = vw;
    canvas.height = vh;
  //   drawGrid(0.25, 30, 30);
    drawDots(1, 20, 20);
  }
  resizeCanvas();
  
  window.onload = function() {
      resizeCanvas();
  }
  
  // grid
  function drawGrid(lineW, cellW, cellH)
  {
    // vertical lines
    for (var x = 0; x <= vw; x += cellW) {
        context.moveTo(x, 0); // x, y
        context.lineTo(x, vh);
    }
    
    // horizontal lines
    for (var y = 0; y <= vh; y += cellH) {
        context.moveTo(0, y); // x, y
        context.lineTo(vw, y);
    }
  
    context.strokeStyle = "#cccccc";
    context.lineWidth = lineW;
    context.stroke();
  }
  
  // dots
  function drawDots(size, cellW, cellW) 
  {
    for (var x = 0; x < vw; x+=cellW) {
      for (var y = 0; y < vh; y+=cellW) {
          context.fillStyle = '#cccccc';   
          context.fillRect(x-size/2,y-size/2,size,size);
        }
    }
  }